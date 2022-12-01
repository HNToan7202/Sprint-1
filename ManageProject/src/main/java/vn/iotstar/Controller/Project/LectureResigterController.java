package vn.iotstar.Controller.Project;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Project;
import vn.iotstar.Model.ProjectModel;
import vn.iotstar.Service.IProjectService;

@Controller
@RequestMapping("/lecture/project")
public class LectureResigterController {

	@Autowired
	IProjectService projectService;

	@GetMapping("")
	public ModelAndView List(ModelMap model) {
		List<Project> project = projectService.findAll();
		model.addAttribute("project", project);
		return new ModelAndView("common/lecproject/list", model);
	}

	@GetMapping("add")
	public String add(Model model) {
		ProjectModel project = new ProjectModel();
		project.setIsEdit(false);
		model.addAttribute("project", project);
		return "common/lecproject/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) throws IOException {
		Optional<Project> opt = projectService.findById(id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			project.setIsEdit(true);
			model.addAttribute("project", project);
			return new ModelAndView("common/lecproject/addOrEdit", model);
		}
		model.addAttribute("message", "project không tồn tại");
		return new ModelAndView("redirect:/project/lecture", model);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("project") ProjectModel project,
			BindingResult result) {
		Project entity = new Project();
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("common/lecproject/addOrEdit");
		}
		BeanUtils.copyProperties(project, entity);
		projectService.save(entity);
		return new ModelAndView("redirect:/project/lecture", model);
	}

	@GetMapping("search")
	public String search() {
		return "common/project/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		projectService.deleteById(id);
		return new ModelAndView("redirect:/project/lecture", model);
	}

}