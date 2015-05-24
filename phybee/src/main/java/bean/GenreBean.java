package bean;

public class GenreBean
{
	private Integer id;
	private String name;

	public GenreBean(Integer id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public GenreBean()
	{
		super();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
