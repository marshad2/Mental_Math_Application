package ProjectCalc;

class User {
	String name;
    int age;
    
    public String getName()  {
    	return name;
    }
    
    public int getAge() {
    	return age;
    }
    
    //Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
