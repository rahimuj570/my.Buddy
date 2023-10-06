package apiCall;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import pojo.PostRequest;
import pojo.UserDetailsTemplate;

public class LocalDb  {
	ObjectOutputStream oos=null;
	ObjectInputStream ois=null;
	File usersLocalDb=new File("usersDb.txt");
	File postsLocalDb=new File("postDb.txt");
	private UserDetailsTemplate users;
	private PostRequest posts;
	private ArrayList<UserDetailsTemplate>usersData=new ArrayList<UserDetailsTemplate>();
	private ArrayList<UserDetailsTemplate>tempUsersData=new ArrayList<UserDetailsTemplate>();
	private ArrayList<PostRequest>postsData=new ArrayList<PostRequest>();
	private ArrayList<PostRequest>tempPostsData=new ArrayList<PostRequest>();

	public LocalDb(UserDetailsTemplate users) throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
		tempUsersData=(ArrayList<UserDetailsTemplate>) getAllUser();
		this.users = users;
		usersData.add(users);
		//usersData.addAll(tempUsersData);
	
		oos=new ObjectOutputStream(new FileOutputStream(usersLocalDb));
		oos.writeObject(usersData);
		oos.close();
		for(var e: usersData) {
			System.out.println(e.getName());
		}
	}

	@SuppressWarnings("unchecked")
	public
	List<UserDetailsTemplate> getAllUser() throws FileNotFoundException, IOException, ClassNotFoundException{
		if(usersLocalDb.isFile()) {
			ois=new ObjectInputStream(new FileInputStream(usersLocalDb));
			usersData=(ArrayList<UserDetailsTemplate>) ois.readObject();
			ois.close();
			return usersData;
		}
		return null;
	}
	
	

	
	public LocalDb(PostRequest post) throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
		tempPostsData=(ArrayList<PostRequest>) getAllPost();
		this.posts = post;
		postsData.add(post);
		//usersData.addAll(tempUsersData);
	
		oos=new ObjectOutputStream(new FileOutputStream(postsLocalDb));
		oos.writeObject(postsData);
		oos.close();
		for(var e: postsData) {
			System.out.println(e.getArea());
		}
	}
	
	@SuppressWarnings("unchecked")
	public
	List<PostRequest> getAllPost() throws FileNotFoundException, IOException, ClassNotFoundException{
		if(postsLocalDb.isFile()) {
			ois=new ObjectInputStream(new FileInputStream(postsLocalDb));
			postsData=(ArrayList<PostRequest>) ois.readObject();
			ois.close();
			return postsData;
		}
		return null;
	}
	
	public LocalDb(List<PostRequest> posts) throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
//		tempTodosData= (ArrayList<Todo>) getAllTodo();
//		this.todos = todos;
//		todosData.add(todos);
		
		oos=new ObjectOutputStream(new FileOutputStream(postsLocalDb));
		oos.writeObject(posts);
		oos.close();
//		for(var e: todosData) {
//			System.out.println(e.getTitle());
//		}
	}
	public LocalDb(ArrayList<UserDetailsTemplate> users) throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
//		tempTodosData= (ArrayList<Todo>) getAllTodo();
//		this.todos = todos;
//		todosData.add(todos);
		
		oos=new ObjectOutputStream(new FileOutputStream(usersLocalDb));
		oos.writeObject(users);
		oos.close();
//		for(var e: todosData) {
//			System.out.println(e.getTitle());
//		}
	}
	
	//toodoo
	/*
	 * public LocalDb(Todo todos) throws FileNotFoundException, IOException,
	 * ClassNotFoundException { super(); tempTodosData= (ArrayList<Todo>)
	 * getAllTodo(); this.todos = todos; todosData.add(todos);
	 * 
	 * oos=new ObjectOutputStream(new FileOutputStream(todoLocalDb));
	 * oos.writeObject(todosData); oos.close(); for(var e: todosData) {
	 * System.out.println(e.getTitle()); } }
	 * 

	 * 
	 * 
	 * 
	 * @SuppressWarnings("unchecked") List<Users> getAllUser() throws
	 * FileNotFoundException, IOException, ClassNotFoundException{
	 * if(usersLocalDb.isFile()) { ois=new ObjectInputStream(new
	 * FileInputStream(usersLocalDb)); usersData=(ArrayList<Users>)
	 * ois.readObject(); ois.close(); return usersData; } return null; }
	 * 
	 * @SuppressWarnings("unchecked") List<Todo> getAllTodo() throws
	 * FileNotFoundException, IOException, ClassNotFoundException{
	 * if(todoLocalDb.isFile()) { ois=new ObjectInputStream(new
	 * FileInputStream(todoLocalDb)); todosData=(ArrayList<Todo>) ois.readObject();
	 * ois.close(); return todosData; } return null; } 
	 */
	 public LocalDb() { super();}

}
