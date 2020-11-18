Public Class clsLine
    Private sp As Point, ep As Point

    Public Sub New(ByVal sp As Point, ByVal ep As Point)
        Me.sp = sp : Me.ep = ep
    End Sub
    Sub Draw(ByVal g As Graphics)
        g.DrawLine(Pens.Blue, sp, ep)
    End Sub
End Class
