package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.chrI_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "string", type = TermBuild.class)
public abstract class chrI_1 extends TermBuild {

	public chrI_1(SourceSection source) {
		super(source);
	}

	/**
	 * Return the one character long string containing the character which code
	 * is code. If code does not belong to the range [0..255], raise a runtime
	 * error: 'chr: character out of range'.
	 * 
	 * @param i
	 * @return
	 */
	@Specialization
	public String doInt(int i) {
		if (i < 0 || i > 255) {
			throw new RuntimeException("chr: character out of range");
		}
		
		return Character.toString((char) i);
	}

	public static TermBuild create(SourceSection source, TermBuild string) {
		return chrI_1NodeGen.create(source, string);
	}
}
