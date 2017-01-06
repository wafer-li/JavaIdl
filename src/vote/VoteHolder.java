package vote;

/**
* vote/VoteHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从vote.idl
* 2017年1月6日 星期五 下午10时13分59秒 JST
*/

public final class VoteHolder implements org.omg.CORBA.portable.Streamable
{
  public vote.Vote value = null;

  public VoteHolder ()
  {
  }

  public VoteHolder (vote.Vote initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = vote.VoteHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    vote.VoteHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return vote.VoteHelper.type ();
  }

}
