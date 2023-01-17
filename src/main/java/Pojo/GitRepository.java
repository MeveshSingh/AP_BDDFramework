package Pojo;

public class GitRepository {
	
	private String name;
	
	private String description;
	
	private String homepage;
	
	private boolean Private;
	
	private boolean has_issues;
	
	private boolean has_projects;
	
	private boolean has_wiki;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getHomepage() {
		return homepage;
	}

	public boolean isPrivate() {
		return Private;
	}

	public boolean isHas_issues() {
		return has_issues;
	}

	public boolean isHas_projects() {
		return has_projects;
	}

	public boolean isHas_wiki() {
		return has_wiki;
	}

	
	public GitRepository setName(String name) {
		this.name = name;
		return this;
	}

	public GitRepository setDescription(String description) {
		this.description = description;
		return this;
	}

	public GitRepository setHomepage(String homepage) {
		this.homepage = homepage;
		return this;
	}

	public GitRepository setPrivate(boolean private1) {
		Private = private1;
		return this;
	}

	public GitRepository setHas_issues(boolean has_issues) {
		this.has_issues = has_issues;
		return this;
	}

	public GitRepository setHas_projects(boolean has_projects) {
		this.has_projects = has_projects;
		return this;
	}

	public GitRepository setHas_wiki(boolean has_wiki) {
		this.has_wiki = has_wiki;
		return this;
	}

	@Override
	public String toString() {
		return "GitRepository [name=" + name + ", description=" + description + ", homepage=" + homepage + ", Private="
				+ Private + ", has_issues=" + has_issues + ", has_projects=" + has_projects + ", has_wiki=" + has_wiki
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (Private ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (has_issues ? 1231 : 1237);
		result = prime * result + (has_projects ? 1231 : 1237);
		result = prime * result + (has_wiki ? 1231 : 1237);
		result = prime * result + ((homepage == null) ? 0 : homepage.hashCode());
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
		GitRepository other = (GitRepository) obj;
		if (Private != other.Private)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (has_issues != other.has_issues)
			return false;
		if (has_projects != other.has_projects)
			return false;
		if (has_wiki != other.has_wiki)
			return false;
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public GitRepository() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
