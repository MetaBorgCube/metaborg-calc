package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.printI_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class printI_1 extends TermBuild {

	public printI_1(SourceSection source) {
		super(source);
	}

	@Specialization
	public String doString(int i) {
		return i + "";
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return printI_1NodeGen.create(source, stringbuild);
	}
}
