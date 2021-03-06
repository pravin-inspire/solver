package org.matheclipse.core.eval.exception;

import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.math.MathException;

public class RuleCreationError extends MathException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4289111239388531874L;

	IExpr fLHS = null;

	IExpr fRHS = null;

	IExpr fCondition = null;

	public RuleCreationError(final IExpr lhs) {
		fLHS = lhs;
	}

	public RuleCreationError(final IExpr lhs, final IExpr rhs, final IExpr condition) {
		fLHS = lhs;
		fRHS = rhs;
		fCondition = condition;
	}

	@Override
	public String getMessage() {
		if (fLHS == null) {
			return "Operation not allowed in server mode.\nUse variable names starting with a '$' character and be sure that you are logged in.";
		}
		if (fCondition != null) {
			return "Error in rule creation: Condition not allowed in rules containing no pattern (" + fLHS.toString() + " "
					+ fRHS.toString() + " " + fCondition.toString() + ")";
		}
		if (fRHS != null) {
			return "Error in rule creation: " + fLHS.toString() + " " + fRHS.toString();
		}
		return "Not allowed left-hand-side expression in server mode: " + fLHS.toString()
				+ "\nUse variable names starting with a '$' character for assignments and be sure that you are logged in.";
	}

}
