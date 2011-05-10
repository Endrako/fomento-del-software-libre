package pos.data;

import java.util.List;

import pos.domain.Tag;

public interface ITagDAO {

		public List<Tag> selectAll();
		public Tag selectTagByID(String idTag);
		public void insertTag(Tag tag);
		public Tag selectTagByName(String name);
}
