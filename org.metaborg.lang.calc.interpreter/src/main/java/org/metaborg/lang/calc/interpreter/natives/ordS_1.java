package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.ordS_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class ordS_1 extends TermBuild {

	public ordS_1(SourceSection source) {
		super(source);
	}

	/**
	 * Return the ascii code of the first character in string and -1 if the
     * given string is empty.
	 * 
	 * @param s
	 * @return
	 */
	@Specialization
	public int doString(String s) {
		if (s.isEmpty()) {
			return -1;
		}
		
		return (int) s.charAt(0);
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return ordS_1NodeGen.create(source, stringbuild);
	}
}
