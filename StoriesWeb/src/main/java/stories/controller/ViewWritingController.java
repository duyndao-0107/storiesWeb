package stories.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Read.entity.AudienceEntity;
import Read.entity.CategoryEntity;
import Read.entity.StoryEntity;

@Transactional
@Controller
@RequestMapping("/writing/")
public class ViewWritingController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("view")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("story", getStories());
		return "writing/view";
	}

	public List<StoryEntity> getStories() {
		Session session = factory.getCurrentSession();
		String hql = "FROM StoryEntity";
		Query query = session.createQuery(hql);
		List<StoryEntity> stories = query.list();
		return stories;
	}
	
	public StoryEntity getStories(Integer id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM StoryEntity where id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		StoryEntity story = (StoryEntity) query.list().get(0);
		return story;
	}
	
	@ModelAttribute("genres")
	public List<CategoryEntity> getGenres() {
		Session session = factory.getCurrentSession();
		String hql = "FROM CategoryEntity";
		Query query = session.createQuery(hql);
		List<CategoryEntity> genres = query.list();
		return genres;
	}
	
	@ModelAttribute("audience")
	public List<AudienceEntity> getAudience() {
		Session session = factory.getCurrentSession();
		String hql = "FROM AudienceEntity";
		Query query = session.createQuery(hql);
		List<AudienceEntity> audience = query.list();
		return audience;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap modelMap) {
		modelMap.addAttribute("story", new StoryEntity());
		return "writing/story";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap modelMap, @ModelAttribute("story") StoryEntity story) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(story);
			t.commit();
			modelMap.addAttribute("message", "Add story successful!");
		}
		catch (Exception e) {
			t.rollback();
			modelMap.addAttribute("message", "Add story failure!");
		}
		finally {
			session.close();
		}
		return "writing/view";
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String update(ModelMap modelMap, @PathVariable("id") Integer id) {
		StoryEntity storyUpdate = getStories(id);
		modelMap.addAttribute("storyUpdate", storyUpdate);
		return "writing/story";
	}
	
	@RequestMapping("update") 
	public String update(ModelMap modelMap, @ModelAttribute("story") StoryEntity story) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(story);
			t.commit();
			modelMap.addAttribute("message", "Update story successful!");
		}
		catch (Exception e) {
			t.rollback();
			modelMap.addAttribute("message", "Update story failure!");
		}
		finally {
			session.close();
		}
		modelMap.addAttribute("story", getStories());
		return "writing/view";
	}
	
	@RequestMapping("delete/{id}") 
	public String delete(ModelMap modelMap, @ModelAttribute("story")StoryEntity story) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(story);
			t.commit();
			modelMap.addAttribute("message", "Delete story successful!");
		}
		catch (Exception e) {
			t.rollback();
			modelMap.addAttribute("message", "Delete story failure!");
		}
		finally {
			session.close();
		}
		modelMap.addAttribute("story", getStories());
		return "writing/view";
	}
}
