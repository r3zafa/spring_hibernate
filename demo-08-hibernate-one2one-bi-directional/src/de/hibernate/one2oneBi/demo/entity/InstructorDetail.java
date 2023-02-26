package de.hibernate.one2oneBi.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// step 1 : annotate the class as an entity and map it to DB table
@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	// step 2: define the fields with DB column names + annotate the fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;

	
	// ** setup mapping to Instructor entity bidirectional
	//Cascade.ALL
	//@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
	// prevent deleting instructor as we delete detail:
	@OneToOne(mappedBy = "instructorDetail", cascade = {
			CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;
	
	


	
	// step 3 - create the constructor
	public InstructorDetail() {
		
	}
	
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	// step 4 - generate getter/setter method
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
		
	//step 5 - generate toString() method
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby
				+ "]";
	}
	


		
}
