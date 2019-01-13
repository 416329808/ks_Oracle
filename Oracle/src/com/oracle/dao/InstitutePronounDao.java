package com.oracle.dao;

import com.oracle.daomain.InstitutePronoun;
/**
 * 通过学院的名称来查找学院的相关信息
 * @author MWY
 *
 */
public interface InstitutePronounDao {
 public InstitutePronoun FindinstitutepronounByname(String InstituteName);
}
