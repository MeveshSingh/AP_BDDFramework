package Tutorial1;

public class GitRepo {
	
	private String name;
	
	private String description;
	
	private String homepage;
	
	private boolean Private;
	
	private boolean is_template;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public boolean isPrivate() {
		return Private;
	}

	public void setPrivate(boolean private1) {
		Private = private1;
	}

	public boolean isIs_template() {
		return is_template;
	}

	public void setIs_template(boolean is_template) {
		this.is_template = is_template;
	}

	@Override
	public String toString() {
		return "GitRepo [name=" + name + ", description=" + description + ", homepage=" + homepage + ", Private="
				+ Private + ", is_template=" + is_template + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (Private ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((homepage == null) ? 0 : homepage.hashCode());
		result = prime * result + (is_template ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GitRepo other = (GitRepo) obj;
		if (Private != other.Private)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		if (is_template != other.is_template)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public GitRepo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
