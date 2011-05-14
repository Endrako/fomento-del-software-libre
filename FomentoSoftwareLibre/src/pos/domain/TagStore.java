package pos.domain;

import java.util.List;

import pos.data.JDBCTagDAO;

public class TagStore {

	private static TagStore tagStore;
	private List<Tag> tags;
	
	public static synchronized TagStore getInstance(){
		if(tagStore ==null){
			tagStore = new TagStore();
		}
		return tagStore;
	}
	
	private TagStore(){
		tags =(new JDBCTagDAO()).selectAll();
	}
	
	public List<Tag> getTags(){
		return tags;
	}
	
	public Tag getTagByID(String tagID){
		return (new JDBCTagDAO()).selectTagByID(tagID);
	}
	
	public Tag getTagByName(String name){
		return (new JDBCTagDAO()).selectTagByName(name);
	}
}
