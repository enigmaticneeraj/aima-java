/*
 * Created on Sep 15, 2003 by Ravi Mohan
 *  
 */
package aima.logic.propositional.parsing.ast;

import java.util.List;

import aima.logic.propositional.parsing.PLVisitor;

public class MultiSentence extends ComplexSentence {
	private String operator;

	private List<Sentence> sentences;

	public MultiSentence(String operator, List<Sentence> sentences) {
		this.operator = operator;
		this.sentences = sentences;
	}

	public String getOperator() {
		return operator;
	}

	public List getSentences() {
		return sentences;
	}

	public boolean equals(Object o) {


		if( this == o ) {
			return true;
		}
		if((o == null) || (this.getClass() != o.getClass())){
			return false;
		}
		MultiSentence sen = (MultiSentence) o;
		return ((sen.getOperator().equals(getOperator())) && (sen
				.getSentences().equals(getSentences())));

	}
	public int hashCode(){
		int result = 17;
		for (Sentence s : sentences){
			result = 37 * result + s.hashCode();
		}
		return result;  
	}

	public String toString() {
		String part1 = "( " + getOperator() + " ";
		for (int i = 0; i < getSentences().size(); i++) {
			part1 = part1 + sentences.get(i).toString() + " ";
		}
		return part1 + " ) ";
	}

	public Object accept(PLVisitor plv, Object arg) {
		return plv.visitMultiSentence(this, arg);
	}

}