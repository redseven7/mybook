package po;

public class book {
		private String authorid;
		private String title;
		private String publishdate;
		private String price;
		private String isbn;
		private String publisher;
		public book(){
			authorid = null;
			title = null;
			publishdate = null;
			price = null;
			isbn = null;
			publisher=null;
		}
		
		public book(String authorid,String title,String publishdate ,String price,String isbn,String publsher){
			this.authorid = authorid;
			this.title = title;
			this.publishdate = publishdate;
			this.price = price;
			this.isbn = isbn;
			this.publisher = publisher;
		}
		public String getAuthorid() {
			return authorid;
		}
		public void setAuthorid(String authorid) {
			this.authorid = authorid;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPublishdate() {
			return publishdate;
		}
		public void setPublishdate(String publishdate) {
			this.publishdate = publishdate;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
	}
//====