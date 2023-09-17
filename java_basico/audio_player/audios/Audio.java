package audio_player.audios;

import audio_player.screen.TerminalTextDisplayer;

public class Audio {
	// VARIABLES
	String title;
	float durarion_in_minutes;
	int total_of_reproductions;
	int number_of_likes;
	float classification_in_stars;
	int total_of_classifications;
	TerminalTextDisplayer screen;
	String author;

	// CONSTRUCTOR
	public Audio(String title, Float duration, String author){
		this.title = title;
		durarion_in_minutes = duration;
		total_of_reproductions = 0;
		number_of_likes = 0;
		classification_in_stars = 0;
		total_of_classifications = 0;
		this.author = author;
		screen = new TerminalTextDisplayer();
	}

	// METHODS
	public void play(){
		incrementTotalOfReproductions();
	}
	public void like(){
		addToNumberOfLikes(1);
	}
	public void dislike(){
		addToNumberOfLikes(-1);
	}
	public void classificate(int grade){
		incrementTotalOfReproductions();
	}

	// GETTERS
	public String getTitle() {
		return title;
	}
	public float getDurationInMinutes() {
		return durarion_in_minutes;
	}
	public int getTotalOfReproductions() {
		return total_of_reproductions;
	}
	public int getNumberOfLikes() {
		return number_of_likes;
	}
	public float getClassificationInStars() {
		return classification_in_stars;
	}
	public int getTotalOfClassifications() {
		return total_of_classifications;
	}
	public String getAuthor() {
		return author;
	}

	// SETTERS
	private void incrementTotalOfReproductions() {
		this.total_of_reproductions++;
	}
	private void addToNumberOfLikes(int number) {
		this.number_of_likes = number_of_likes + number;
	}
	private void addClassification(float classification_in_stars) {
		this.classification_in_stars = classification_in_stars;
	}
}
