package main.service.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import main.service.BoardVO;


@Repository("boardDAO")
public class BoardDAO extends EgovAbstractDAO{

	public String insertBoard(BoardVO vo) {
		return (String) insert("boardDAO.insertBoard",vo);
	}

	public List<?> selectBoardList(BoardVO vo) {
		return list("boardDAO.selectBoardList",vo);
	}

	public int selectBoardTotal(BoardVO vo) {
		return (int) select("boardDAO.selectBoardTotal",vo);
	}

}