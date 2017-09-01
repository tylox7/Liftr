public class Lift {

   // Variables
   private int sets;
   private int reps;

   private String liftName;
   private String comments;

   // Default Constructor
   public Lift() {
      liftName = "Default";
      sets = 3;
      reps = 10;
      comments = "";
   }

   // Constructor that I'll mainly use for now.
   public Lift(String liftName, int sets, int reps) {
      this.liftName = liftName;
      this.sets = sets;
      this.reps = reps;
      comments = "";
   }

   //Getters and Setters
   public int getSets() {
      return sets;
   }

   public void setSets(int sets) {
      this.sets = sets;
   }

   public int getReps() {
      return reps;
   }

   public void setReps(int reps) {
      this.reps = reps;
   }

   public String getLiftName() {
      return liftName;
   }

   public void setLiftName(String liftName) {
      this.liftName = liftName;
   }

   public String getComments() {
      return comments;
   }

   public void setComments(String comments) {
      this.comments = comments;
   }
}
