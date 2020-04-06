package io.github.hooj0.generic.generictype;

/**
 * 基础商务
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:22:16
 */
public class BaseBiz<T> {

	private BaseDao<T> dao;

	public BaseDao<T> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}
	
	public static void main(String[] args) {
		BaseBiz<String> biz = new BaseBiz<String>();
		biz.setDao(new BaseDao<String>());
		//biz.setDao(new BaseDao<Integer>());
		BaseDao<String> dao = biz.getDao();
		//BaseDao<Integer> dao2 = biz.getDao();
		dao.add("abc");
		System.out.println(dao.get());
	}
}

class BaseDao<T> {
	private T t;
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return this.t;
	}
}