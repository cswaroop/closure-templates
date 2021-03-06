/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.template.soy.soytree;

import com.google.template.soy.soytree.SoyNode.MsgSubstUnitNode;


/**
 * Node representing a 'remainder' section in a 'plural' block.
 *
 * <p> Important: Do not use outside of Soy code (treat as superpackage-private).
 *
 */
public class MsgPluralRemainderNode extends AbstractSoyNode implements MsgSubstUnitNode {


  /** The source string. */
  private final String sourceString;


  /**
   * @param origPrintNode The print node containing "remainder".
   */
  public MsgPluralRemainderNode(PrintNode origPrintNode) {
    super(origPrintNode.getId());
    this.sourceString = origPrintNode.toSourceString();
  }


  /**
   * Copy constructor.
   * @param orig The node to copy.
   */
  protected MsgPluralRemainderNode(MsgPluralRemainderNode orig) {
    super(orig);
    this.sourceString = orig.sourceString;
  }


  @Override public Kind getKind() {
    return Kind.MSG_PLURAL_REMAINDER_NODE;
  }


  @Override public String getBaseVarName() {
    throw new AssertionError();  // should never happen (removed by RewriteRemainderNodesVisitor)
  }


  @Override public boolean shouldUseSameVarNameAs(MsgSubstUnitNode other) {
    throw new AssertionError();  // should never happen (removed by RewriteRemainderNodesVisitor)
  }


  @Override public String toSourceString() {
    return sourceString;
  }


  @Override public MsgBlockNode getParent() {
    return (MsgBlockNode) super.getParent();
  }


  @Override public MsgPluralRemainderNode clone() {
    return new MsgPluralRemainderNode(this);
  }

}
