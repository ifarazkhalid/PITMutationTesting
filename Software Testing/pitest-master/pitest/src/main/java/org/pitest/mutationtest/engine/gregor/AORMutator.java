import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.*;

import java.util.*;

public enum AORMutator implements MethodMutatorFactory {

  AORMutator;

	class AORMethodVisitor extends AbstractInsnMutator {

		  AORMethodVisitor(final MethodMutatorFactory factory,
		                   final MethodInfo methodInfo, final MutationContext context,
		                   final MethodVisitor writer) {
		    super(factory, methodInfo, context, writer);
		  }
	
		  private static final Map<Integer, ZeroOperandMutation> TOTAL_NUM_MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();
  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AORMethodVisitor(this, methodInfo, context, methodVisitor);
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
	  
	//Longs
	    TOTAL_NUM_MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LSUB,
	            "Replaced long addition with subtraction (AOR)"));
	    TOTAL_NUM_MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LADD,
	            "Replaced long subtraction with addition (AOR)"));
	    TOTAL_NUM_MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
	            "Replaced long modulus with multiplication (AOR)"));
	    TOTAL_NUM_MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LDIV,
	            "Replaced long multiplication with division (AOR)"));
	    TOTAL_NUM_MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LMUL,
	            "Replaced long division with multiplication (AOR)"));
	  
	  
	  
	  
    //Ints
    TOTAL_NUM_MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer multiplication with division (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer division with multiplication (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer modulus with multiplication (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer addition with subtraction (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IADD,
            "Replaced integer subtraction with addition (AOR)"));
    

    // Floats
    TOTAL_NUM_MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float division with multiplication (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float modulus with multiplication (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FSUB,
            "Replaced float addition with subtraction (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FADD,
            "Replaced float subtraction with addition (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FDIV,
            "Replaced float multiplication with division (AOR)"));
   

    // Doubles
    TOTAL_NUM_MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DSUB,
            "Replaced double addition with subtraction (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double division with multiplication (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double modulus with multiplication (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DADD,
            "Replaced double subtraction with addition (AOR)"));
    TOTAL_NUM_MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DDIV,
            "Replaced double multiplication with division (AOR)"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMUTATIONS() {
    return TOTAL_NUM_MUTATIONS;
  }

}