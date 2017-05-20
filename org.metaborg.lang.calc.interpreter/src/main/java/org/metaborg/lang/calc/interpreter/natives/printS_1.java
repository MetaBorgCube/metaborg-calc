package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.printS_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class printS_1 extends TermBuild {

	public printS_1(SourceSection source) {
		super(source);
	}

	@Specialization
	public String doString(String s) {
		System.out.print(s);
		
		return s;
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return printS_1NodeGen.create(source, stringbuild);
	}
}
