Imports System.Math

Public Class clsGenXY
    Private cx As Single, cy As Single, r As Single ' 圆心与半径
    Private delta As Single ' 每个时间间隔，改变的角度值
    Private angle As Single ' 当前角度值

    Public Sub New(ByVal cx As Single, ByVal cy As Single, ByVal r As Single, ByVal k As Integer)
        Me.cx = cx : Me.cy = cy : Me.r = r
        delta = 2 * Math.PI / k
        angle = 0
    End Sub
    Public Sub DoTick()
        angle += delta
    End Sub
    Function GetX() As Single
        Return cx + r * Cos(angle)
    End Function
    Function GetY() As Single
        Return cx + r * Sin(angle)
    End Function

    Sub Draw(ByVal g As Graphics)
        g.DrawEllipse(Pens.Blue, cx - r, cy - r, 2 * r, 2 * r)
        '      g.DrawEllipse(Pens.Blue, GetX() - 2, GetY() - 2, 4, 4)
    End Sub

End Class
