import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.*;

import java.util.*;

public enum AODMutator implements MethodMutatorFactory {

  AODMutator;

	class AODMethodVisitor extends AbstractInsnMutator {

		  AODMethodVisitor(final MethodMutatorFactory factory,
		                   final MethodInfo methodInfo, final MutationContext context,
		                   final MethodVisitor writer) {
		    super(factory, methodInfo, context, writer);
		  }
	
		  private static final String                            MSG   = "Second operand is removed (AOD)";
		  private static final Map<Integer, ZeroOperandMutation> TOTAL_NUM_MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();
	
  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AODMethodVisitor(this, methodInfo, context, methodVisitor);
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

  
  
  
  static {
    TOTAL_NUM_MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.POP, "AOD Mutator:  INT - Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.POP, "AOD Mutator: FLOAT - Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.POP, "AOD Mutator: INT -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.POP2, "AOD Mutator: DOUBLE -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.POP2, "AOD Mutator: LONG -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.POP, "AOD Mutator: INT - Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.POP, "AOD Mutator: FLOAT - Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.POP, "AOD Mutator: INT -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.POP, "AOD Mutator: FLOAT -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.POP, "AOD Mutator:INT -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.POP, "AOD Mutator: FLOAT - Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.POP2, "AOD Mutator:DOUBLE -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.POP2, "AOD Mutator: LONG -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.POP2, "AOD Mutator: DOUBLE - Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.POP2, "AOD Mutator: LONG -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.POP, "AOD Mutator: FLOAT -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.POP2, "AOD Mutator: DOUBLE - Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.POP2, "AOD Mutator: LONG -  Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.POP2, "AOD Mutator: DOUBLE - Second operand is removed (AOD)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.POP2, "AOD Mutator: LONG - Second operand is removed (AOD)"));


  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return TOTAL_NUM_MUTATIONS;
  }

}