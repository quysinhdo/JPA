package vn.iotstar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;

public class Test {
	public static void main(String[] args) {
		System.out.println("Classpath: " + System.getProperty("java.class.path"));
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		// insert
		Category cate = new Category();
		cate.setCategoryname("Iphone");
		cate.setImages("abc.jpg");
		cate.setStatus(1);
		Video video = new Video();
		video.setVideoId("v001");
		video.setTitle("test");
		video.setCategory(cate);

		try {
			trans.begin();
			enma.persist(cate);
			enma.persist(video);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
}
