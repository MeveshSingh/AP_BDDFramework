package Resources;

import Pojo.GitRepository;

public class GitRepositoryTestData {
	
	
	public String createGitRepository(String name,String desc,String homepage,boolean Private,
			boolean issue,boolean project,boolean wiki)
	{
		
		GitRepository gitrepos =new GitRepository().setName(name).setDescription(desc).setHomepage(homepage)
		.setPrivate(Private).setHas_issues(issue).setHas_projects(project).setHas_wiki(wiki);
		
		return UtilsClass.convertJavaToJson(gitrepos);
	}

	
	public String updateNewRepositoryName(String newname)
	{
		GitRepository git = new GitRepository().setName(newname);
		return UtilsClass.convertJavaToJson(git);
	}
	
}
