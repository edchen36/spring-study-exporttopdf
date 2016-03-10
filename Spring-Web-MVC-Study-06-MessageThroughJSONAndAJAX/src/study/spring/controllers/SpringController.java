package study.spring.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import study.spring.domain.Contact;
import study.spring.domain.Message;
import study.spring.service.ContactService;
import study.spring.service.MessageService;

@Controller
public class SpringController {
	
	@Autowired
	private ContactService contactservice;
	
	@Autowired
	private MessageService messageservice;
	
	@RequestMapping("/")
	public String showHomePage() {
		return "index";
	}
	
	@RequestMapping("newContactForm")
	public String showContactForm(Model model) {
		model.addAttribute("contact", new Contact());
		return "ContactForm";
	}
	
	@RequestMapping("listAllContacts")
	public String showAllContacts(Model model) {
		ArrayList<Contact> allContacts = (ArrayList<Contact>) contactservice.getAllContacts();
		model.addAttribute("allContacts", allContacts);
		return "ContactList";
	}
	
	@RequestMapping("newMsgForm")
	public String showMessageForm(Model model) {
		model.addAttribute("message", new Message());
		return "MessageForm";
	}
	
	
	@RequestMapping(value="/addContact", method=RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("contact")@Valid Contact contact,BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("ContactForm");
		}else {
			contactservice.addContact(contact);
			mv.setViewName("redirect:/listAllContacts");
		}
		return mv;
	}
	
	@RequestMapping(value="/getContacts",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Map<String,Object> getJSONContacts(){
		ArrayList<Contact> contactList = (ArrayList<Contact>) contactservice.getAllContacts();
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("contactList", contactList);
		data.put("total", contactList.size());
		return data;
	}
	
	@RequestMapping(value="/getAllMessages", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Map<String,Object> getJSONMessages(){
		ArrayList<Message> messageList = (ArrayList<Message>) messageservice.getAllMessages();
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("mymessageList", messageList);
		data.put("total", messageList.size());
		return data;
		
	}
	
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	public ModelAndView sendMessage(@ModelAttribute("message")@Valid Message message,BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("MessageForm");
		} else {
			messageservice.sendMessage(message);
			mv.setViewName("redirect:/");
			System.out.println(message.toString());
		}
		return mv;
	}
	
	@RequestMapping("ContactListPDF")
	public ModelAndView downloadAsPdf() {
		ArrayList<Contact> contactList = (ArrayList<Contact>) contactservice.getAllContacts();
		ModelAndView mv = new ModelAndView("pdfView","contactList",contactList);
		return mv;
	}
	
	@RequestMapping("ContactListExcel")
	public ModelAndView saveAsExcel() {
		ArrayList<Contact> contactList = (ArrayList<Contact>) contactservice.getAllContacts();
		ModelAndView mv = new ModelAndView("excelView","contactList",contactList);
		
		return mv;
	}
	
	@RequestMapping("delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer id) {
		System.out.println("Deleting " + id );
		contactservice.deleteContact(id);
		return "redirect:/listAllContacts";
		
	}
	
	@RequestMapping("viewMessages")
	public String viewMessage() {
		return "ViewMessage";
	}
	
	
	

}
