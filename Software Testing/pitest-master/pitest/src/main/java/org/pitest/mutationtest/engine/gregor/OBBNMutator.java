import org.objectweb.asm.MethodVisitor;
import java.util.*;
import org.pitest.mutationtest.engine.gregor.*;
import org.objectweb.asm.Opcodes;




public enum OBBNMutator implements MethodMutatorFactory {

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

  OBBNMutator;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new OBBNMethodVisitor(this, methodInfo, context, methodVisitor);
  }

  @Override
  public String getGloballyUniqueId() {
    return this.getClass().getName();
  }

  @Override
  public String getName() {
    return name();
  }

}

//Doing it for integers and long values.
class OBBNMethodVisitor extends AbstractInsnMutator {

  OBBNMethodVisitor(final MethodMutatorFactory factory,
                    final MethodInfo methodInfo, final MutationContext context,
                    final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {

    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
            "Replaced bitwise OR with AND (OBBN)"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
            "Replaced bitwise AND with OR (OBBN)"));

    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
            "Replaced bitwise OR with AND (OBBN)"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
            "Replaced bitwise AND with OR (OBBN)"));
    
  }

  

}