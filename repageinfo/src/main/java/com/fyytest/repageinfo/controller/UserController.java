package com.fyytest.repageinfo.controller;

import com.fyytest.repageinfo.pojo.User;
import com.fyytest.repageinfo.pojo.query.UserQuery;
import com.fyytest.repageinfo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    //    按照userquery展示
    @RequestMapping("/")
    public String index(Model model, UserQuery userQuery) {
        PageInfo<User> userPageInfo = userService.listUserByName(userQuery);
        model.addAttribute("page", userPageInfo);
        return "index";
    }

    //前端传值 post方法
    //    根据姓名查找信息
    @PostMapping("/")
    public String listUserByName(Model model, UserQuery userQuery) {
        PageInfo<User> userPageInfo = userService.listUserByName(userQuery);
        model.addAttribute("page", userPageInfo);
        return "index";
    }

    //   根据id 删除信息
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        boolean b = userService.deleteUser(id);
//        删除成功重定向
        if (b) {
            redirectAttributes.addFlashAttribute("message", "删除成功");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("message", "删除失败");
            return "redirect:/";
        }
    }

    //编辑用户 新增用户
    @GetMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
//        把整个user传进去
        model.addAttribute("user", userService.queryUserId(id));
        return "editUser";
    }

    //    post提交修改信息
    @PostMapping("/edit")
    public String edit(User user, RedirectAttributes attributes) {
        UserQuery userQuery = new UserQuery();
        Integer id = user.getId();
        userQuery.setName(user.getName());
        PageInfo<User> userPageInfo = userService.listUserByName(userQuery);
        if(id != null){
            if(userPageInfo.getSize() == 0){
                boolean b = userService.updateUser(user);
                if(b){
                    attributes.addFlashAttribute("message"," 更新用户成功");
                    return "redirect:/";
                }else {
                    attributes.addFlashAttribute("message","更新用户失败");
                    return "redirect:/";
                }
            }else {
                attributes.addFlashAttribute("message","该用户名已存在");
                return "redirect:/edit/"+user.getId();
            }
        }else {
            if(userPageInfo.getSize() == 0){
                boolean b = userService.insertUser(user);
                if(b){
                    attributes.addFlashAttribute("message"," 新增用户成功");
                    return "redirect:/";
                }else {
                    attributes.addFlashAttribute("message","新增用户失败");
                    return "redirect:/";
                }
            }else {
                attributes.addFlashAttribute("message","该用户名已存在");
                return "redirect:/";
            }
        }
    }

    @GetMapping("/update")
    public String toUpdate(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "editUser";
    }
}
