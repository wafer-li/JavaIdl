import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import vote.Vote;
import vote.VoteHelper;

/**
 * This is the Server class
 * Please put some info here.
 *
 * @author Wafer Li
 * @since 17/1/6 22:47
 */
public class Server {
    public static void main(String[] args) {

        try {
            ORB orb = ORB.init(args, null);

            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            VoteService voteService = new VoteService();
            voteService.setOrb(orb);

            Object reference = rootPoa.servant_to_reference(voteService);
            Vote vote = VoteHelper.narrow(reference);

            Object nameServiceReference = orb.resolve_initial_references("NameService");
            NamingContextExt namingContextExt = NamingContextExtHelper.narrow(nameServiceReference);

            String name = "Vote";
            NameComponent path[] = namingContextExt.to_name(name);
            namingContextExt.rebind(path, vote);

            System.out.println("VoteServer ready and waiting ...");

            orb.run();

            System.in.read();
            orb.shutdown(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
