import org.objectweb.asm.MethodVisitor;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.objectweb.asm.Opcodes;

import org.pitest.mutationtest.engine.gregor.AbstractJumpMutator;

import java.util.*;

public enum RORMutator implements MethodMutatorFactory {

  ROR_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new RORMethodVisitor(this, context, methodVisitor);
  }
  @Override
  public String getName() {
    return name();
  }
  @Override
  public String getGloballyUniqueId() {
    return this.getClass().getName();
  }

}

class RORMethodVisitor extends AbstractJumpMutator {
  private static final Map<Integer, Substitution> TOTAL_NUM_MUTATIONS   = new HashMap<Integer, Substitution>();
  private static final String                     OVERVIEW = "Relational Operator Replacement Mutator (ROR)";
 
  @Override
  protected Map<Integer, Substitution> getMUTATIONS() {
    return TOTAL_NUM_MUTATIONS;
  }

  static {
    

    // Compares two values
    TOTAL_NUM_MUTATIONS.put(Opcodes.IF_ICMPNE, new Substitution(Opcodes.IF_ICMPEQ, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IF_ICMPGE, new Substitution(Opcodes.IF_ICMPLT, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IF_ICMPGT, new Substitution(Opcodes.IF_ICMPLE, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IF_ICMPLT, new Substitution(Opcodes.IF_ICMPGE, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IF_ICMPEQ, new Substitution(Opcodes.IF_ICMPNE, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IF_ICMPLE, new Substitution(Opcodes.IF_ICMPGT, OVERVIEW));

 // Compares a single value to 0
    TOTAL_NUM_MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFNE, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFEQ, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFLE, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFGE, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFGT, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFLT, OVERVIEW));
    
    
    // Compares two object references and if they refer to the same object, then they are equal
    TOTAL_NUM_MUTATIONS.put(Opcodes.IF_ACMPNE, new Substitution(Opcodes.IF_ACMPEQ, OVERVIEW));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IF_ACMPEQ, new Substitution(Opcodes.IF_ACMPNE, OVERVIEW));
    
  }

  RORMethodVisitor(final MethodMutatorFactory factory,
                   final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(factory, context, delegateMethodVisitor);
  }

}