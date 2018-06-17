package pl.triskelion16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.triskelion16.entity.Category;
import pl.triskelion16.repository.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	/***** FIND *************************************************/
	@GetMapping("/list")
	public String listAll(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "category/list";
	}
	
	/***** ADD **********************************************/
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("categories", new Category());
		return "category/add";
	}
	
	@PostMapping("/add")
	public String save(@ModelAttribute Category category) {
		categoryRepository.save(category);
		return "redirect:/category/list";
	}
	
	/***** UPDATE ************************************************/
	@GetMapping("/edit/{id}")
	public String update(@PathVariable long id, Model model) {
		model.addAttribute("categories", categoryRepository.findOne(id));
		return "category/add";
	}
	
	@PostMapping("/edit/{id}")
	public String editForm(@ModelAttribute Category category) {
		categoryRepository.save(category);
		return "redirect:/category/list";
	}
	
	/***** DELETE ********************************************/
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable long id) {
		categoryRepository.delete(id);
		return "redirect:/category/list";
	}
	
	
}
