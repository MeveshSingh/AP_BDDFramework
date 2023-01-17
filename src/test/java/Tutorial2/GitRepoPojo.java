package Tutorial2;

public class GitRepoPojo {

	private String name;

	private String description;

	private String homepage;

	private boolean Private;

	private boolean is_template;

	public String getName() {
		return name;
	}

	public GitRepoPojo setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public GitRepoPojo setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getHomepage() {
		return homepage;
	}

	public GitRepoPojo setHomepage(String homepage) {
		this.homepage = homepage;
		return this;
	}

	public boolean isPrivate() {
		return Private;
	}

	public GitRepoPojo setPrivate(boolean private1) {
		Private = private1;
		return this;
	}

	public boolean isIs_template() {
		return is_template;
	}

	public GitRepoPojo setIs_template(boolean is_template) {
		this.is_template = is_template;
		return this;
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
		GitRepoPojo other = (GitRepoPojo) obj;
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

	public GitRepoPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
