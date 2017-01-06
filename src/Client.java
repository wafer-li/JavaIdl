import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import vote.Vote;
import vote.VoteHelper;

/**
 * This is the Client class
 * Please put some info here.
 *
 * @author Wafer Li
 * @since 17/1/6 23:04
 */
public class Client {
    private static Vote vote;

    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            Object namingServicesReference = orb.resolve_initial_references("NameService");
            NamingContextExt namingContextExt = NamingContextExtHelper.narrow(namingServicesReference);

            String name = "Vote";
            vote = VoteHelper.narrow(namingContextExt.resolve_str(name));

            vote.castVote("candidate2");
            System.out.println("为 candidate2 投票完成！");
            vote.castVote("candidate8");
            System.out.println("为 candidate8 投票完成！");
            vote.castVote("candidate9");
            System.out.println("为 candidate9 投票完成！");
            vote.castVote("candidate2");
            System.out.println("为 candidate2 投票完成！");
            vote.castVote("candidate5");
            System.out.println("为 candidate5 投票完成！");
            vote.castVote("candidate4");
            System.out.println("为 candidate4 投票完成！");

            System.out.println();
            System.out.println("最终结果:");

            System.out.print(vote.getList());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
