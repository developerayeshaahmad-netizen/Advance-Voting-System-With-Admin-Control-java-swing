import java.io.*;
import java.util.ArrayList;


public class Filehandler {
    private static final String USER_FILE = "users.dat";
    private static final String CANDIDATE_FILE = "candidates.dat";

    // Save Users to file
    public static void saveUsers(ArrayList<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) { e.printStackTrace(); }
    }

    // Load Users from file
    public static ArrayList<User> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            return (ArrayList<User>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); } // Return empty list if file not found
    }

    // Save Candidates to file
    public static void saveCandidates(ArrayList<Candidate> candidates) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CANDIDATE_FILE))) {
            oos.writeObject(candidates);
        } catch (IOException e) { e.printStackTrace(); }
    }

    // Load Candidates from file
    public static ArrayList<Candidate> loadCandidates() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CANDIDATE_FILE))) {
            return (ArrayList<Candidate>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
