import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import vote.VotePOA;

/**
 * This is the Server class
 * Please put some info here.
 *
 * @author Wafer Li
 * @since 17/1/6 22:15
 */
public class Server extends VotePOA{

    private List<Candidate> candidates;

    public Server() {
        candidates = IntStream.rangeClosed(1, 10)
                .mapToObj(value -> new Candidate("candidate " + value, 0))
                .collect(Collectors.toList());
    }

    @Override
    public String getList() {

        StringBuilder stringBuilder = new StringBuilder();

        candidates.forEach(candidate -> {
            stringBuilder
                    .append("Name: ")
                    .append(candidate.getName())
                    .append(", ")
                    .append("Vote: ")
                    .append(candidate.getVote())
                    .append("\n");
        });

        return stringBuilder.toString();
    }

    @Override
    public void castVote(String name) {

    }


}
