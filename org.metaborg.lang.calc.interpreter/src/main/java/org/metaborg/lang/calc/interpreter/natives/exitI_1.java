package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.exitI_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class exitI_1 extends TermBuild {

	public exitI_1(SourceSection source) {
		super(source);
	}

	/**
	 * Exit the program with exit code status.
	 * 
	 * @param i
	 * @return
	 */
	@Specialization
	public int doInt(int i) {
		System.exit(i);
		
		return 0;
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return exitI_1NodeGen.create(source, stringbuild);
	}
}
