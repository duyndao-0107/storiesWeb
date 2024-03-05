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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Read.entity.Chapter;
import Read.entity.StoryEntity;

@Transactional
@Controller
@RequestMapping("/chapter/")
public class ChapterController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("detail/{id}")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("chapter", getChapters()); 
		return "chapter/detail";
	}

	public List<StoryEntity> getChapters() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Chapter";
		Query query = session.createQuery(hql);
		List<StoryEntity> stories = query.list();
		return stories;
	}
	
	public Chapter getChapters(Integer id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Chapter where idStory= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Chapter chap = (Chapter) query.list().get(0);
		return chap;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap modelMap) {
		modelMap.addAttribute("chapter", new Chapter());
		return "chapter/write";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap modelMap, @ModelAttribute("chapter") Chapter chap) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(chap);
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
		return "chapter/detail";
	}
}
