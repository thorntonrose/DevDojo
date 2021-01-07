import java.util.*;

public class Pipeline {
   public static void main(String[] args) {
      List<Object> builders = Arrays.asList(new Object[] { new Make(), new MakeDocker(),
         new HashMap() });

      for (Object b : builders) {
         ((Builder) b).build(null);
      }
   }
}
