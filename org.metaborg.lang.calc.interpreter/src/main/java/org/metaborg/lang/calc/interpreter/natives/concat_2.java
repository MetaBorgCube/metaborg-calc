package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.concat_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;
import org.metaborg.meta.lang.dynsem.interpreter.terms.IListTerm;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({ @NodeChild(value = "left", type = TermBuild.class),
		@NodeChild(value = "right", type = TermBuild.class) })
public abstract class concat_2 extends TermBuild {

	public concat_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public IListTerm doLists(IListTerm left, IListTerm right) {
		return left.addAll(right.take(right.size()));
	}

	public static TermBuild create(SourceSection source, TermBuild left, TermBuild right) {
		return concat_2NodeGen.create(source, left, right);
	}

}
