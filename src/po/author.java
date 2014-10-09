package po;
//++++++
public class author {
		private String authorid;
		private String name;
		private String age ;
		private String country;		
		public author(){
			authorid = null;
			name = null;
			age = null;
			country = null;
		}
		
		public author(String authorid,String name,String age,String country){
			this.authorid=authorid;
			this.name=name;
			this.age=age;
			this.country=country;
		}
		public void setAuthorid(String authorid) {
			this.authorid = authorid;
		}

		public String getAuthorid() {
			return authorid;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getAge() {
			return age;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCountry() {
			return country;
		}

//////
}
