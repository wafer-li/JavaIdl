/**
 * This is the Candidate class
 * Please put some info here.
 *
 * @author Wafer Li
 * @since 17/1/6 22:17
 */
public class Candidate {
    private String name;
    private int vote;

    Candidate(String name, int vote) {
        this.name = name;
        this.vote = vote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
