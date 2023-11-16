package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Book_Lib")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String book_Name;
	private String author;
	private String journal;
	private double price;
	
	  public int getId() { return id; } public void setId(int id) { this.id = id; }
	  public String getBook_Name() { return book_Name; } public void
	  setBook_Name(String book_Name) { this.book_Name = book_Name; } public String
	  getAuthor() { return author; } public void setAuthor(String author) {
	  this.author = author; } public String getJournal() { return journal; } public
	  void setJournal(String journal) { this.journal = journal; } public double
	  getPrice() { return price; } public void setPrice(double price) { this.price
	  = price; }
	 
	
	
	
	
	

}
