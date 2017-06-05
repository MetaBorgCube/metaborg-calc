package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.printB_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class printB_1 extends TermBuild {

	public printB_1(SourceSection source) {
		super(source);
	}

	@Specialization
	public String doString(java.math.BigDecimal b) {
		String s = b.toString();
		System.out.println(s);
		return s;
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return printB_1NodeGen.create(source, stringbuild);
	}
}
