public class Main {		
	
	public static void main(String[] args) {
		
		String query = ;  // get query
		String escapedQuery = getEscapedQuery(query);  // escape the query
		
		if (infobox)  // part 1
		{
			ArrayList<String> mids = getMids(escapedQuery);  // call the Freebase Search API and get a list of mids from the result. The highest ranked mid should be the first one in the list.
			Entities es = new Entities(mids);
			
			Entity e = es.GetNextEntity();  // it returns the next highest ranked entity
			ArrayList<String> types = getTypes(e.mid);  // call the Freebase Topic API and get a list of types from the result. No need to filter out types that we are not interested in.
			e.setType(types);
			
			while (!e.hasTypeOfInterest())
			{
				e = es.GetNextEntity();
				ArrayList<String> types = getTypes(e.mid);
				e.setType(types);				
			}
			
			if (e.hasTypeOfInterest())
			{
				for (EntityType et : e.getTypes())
				{
					switch (et.getType())
					{
						case "Person": SetPersonProperties((PersonType)et);
						case "Author": SetAuthorProperties((AuthorType)et);
						case "Actor": SetActorProperties((ActorType)et);
						case "BusinessPerson": SetBusinessPersonProperties((BusinessPersonType)et);
						case "League": SetLeagueProperties((LeagueType)et);
						case "SportsTeam": SetSportsTeamProperties((SportsTeamType)et);
					} 
					String freebaseType = et.getFreebaseType();
					e.SetProperty(freebaseType, name, values)
				}
				
				String infobox = e.getInfobox();
				// display the infobox
			}
			else
			{
				// display "no match" message
			}
		}
		else if (question)  // part 2
		{
			if (validateQuery(query))
			{
				String mql = getMql(query);
				String result = getAnswer(mql);  // call the Freebase MQL API and get the answers.
				// display the result
			}
		}
	}
	
	private void getEscapedQuery(String query)
	{
		
	}
	
	private ArrayList<String> getMids(String query)
	{
		
	}
	
	private ArrayList<String> getTypes(String mid)
	{
		
	}
	
	private void SetPersonProperties(PersonType pt)
	{
		String freebaseType = pt.getFreebaseType();
		
		// search for properties for the freebase type in the result.
		// if there are multiple, call the add method for each. for example, if there are two names, call .AddName(name1) and call .AddName(name2)
		pt.AddName(name);
		pt.AddBirthday(birthday);
	}
	
	private void SetAuthorProperties(AuthorType pt)
	{
		
	}	
}
	  