import org.omg.CORBA.ORB;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import vote.VotePOA;

/**
 * This is the VoteService class
 * Please put some info here.
 *
 * @author Wafer Li
 * @since 17/1/6 22:15
 */
public class VoteService extends VotePOA{

    private List<Candidate> candidates;

    private ORB orb;

    VoteService() {
        candidates = IntStream.rangeClosed(1, 10)
                .mapToObj(value -> new Candidate("candidate" + value, 0))
                .collect(Collectors.toList());
    }

    @Override
    public String getList() {

        StringBuilder stringBuilder = new StringBuilder();

        candidates.forEach(candidate -> stringBuilder
                .append("Name: ")
                .append(candidate.getName())
                .append(", ")
                .append("Vote: ")
                .append(candidate.getVote())
                .append("\n"));

        return stringBuilder.toString();
    }

    @Override
    public void castVote(String name) {
        candidates.forEach(candidate -> {
            if (candidate.getName().equals(name)){
                candidate.setVote(candidate.getVote() + 1);
            }
        });
    }


    void setOrb(ORB orb) {
        this.orb = orb;
    }
}
