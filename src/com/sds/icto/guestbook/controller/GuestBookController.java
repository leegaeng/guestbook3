package com.sds.icto.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.guestbook.dao.GuestbookDao;
import com.sds.icto.guestbook.vo.Guestbook;

@Controller
public class GuestBookController {

	@Autowired
	GuestbookDao guestbookDao;

	@RequestMapping("/index")
	public String index(Model m) {

		List<Guestbook> list = guestbookDao.fetchList();
		m.addAttribute("list", list);

		return "/views/index.jsp";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@RequestParam("name") String name,
			@RequestParam("pass") String password,
			@RequestParam("content") String message) {

		Guestbook vo = new Guestbook();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);

		guestbookDao.insert(vo);

		return "redirect:/index";
	}

	@RequestMapping("/deleteform")
	public String deleteform(String id, Model m) {

		m.addAttribute("id", id);

		return "/views/deleteform.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(String id, String password){
		
		guestbookDao.delete(Integer.parseInt(id), password);
		
		return "redirect:/index";
	}

}
