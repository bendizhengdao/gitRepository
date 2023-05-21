package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssm.bean.Follow;
import com.ssm.bean.ShortUserInfo;

public interface FollowMapper {
	/**
	 * 查询关注信息
	 * @param id
	 * @param followUserId
	 * @return
	 */
	@Select("select id,user_id,follow_user_id,is_valid from t_follow"
			+ " where user_id = #{userId} and follow_user_id = #{followUserId}")
	Follow selectFollow(@Param("userId")Integer id,@Param("followUserId")Integer followUserId);
	
	/**
	 * 添加关注信息
	 * @param userId
	 * @param followUserId
	 * @return
	 */
	@Insert("insert into t_follow(user_id,follow_user_id,is_valid,create_date,update_date )"
			+ "values(#{userId},#{followUserId},1,now(),now())")
	int save(@Param("userId")Integer userId,@Param("followUserId")Integer followUserId);
	
	/**
	 * 修改关注信息
	 * @param id
	 * @param isValid
	 * @return
	 */
	@Update("update t_follow set is_valid=#{isValid},update_date=now() where id = #{id}")
	int update(@Param("id")Integer id,@Param("isValid")int isValid);

	/**
     * 根据 ID 集合查询多个食客信息
     * @param ids
     * @return
     */
    @Select("<script> " +
            " select id, nickname, avatar_url from t_diners " +
            " where is_valid = 1 and id in " +
            " <foreach item=\"id\" collection=\"ids\" open=\"(\" separator=\",\" close=\")\"> " +
            "   #{id} " +
            " </foreach> " +
            " </script>")
    List<ShortUserInfo> findByIds(@Param("ids") String[] ids);

}
