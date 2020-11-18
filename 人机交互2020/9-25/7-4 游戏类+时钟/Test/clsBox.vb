Public Class clsBox

    Private Cx As Single, Cy As Single
    Private Wx As Single, Wy As Single

    Sub New(ByVal cx As Single, ByVal cy As Single, ByVal wx As Single, ByVal wy As Single)
        Me.Cx = cx : Me.Cy = cy
        Me.Wx = wx : Me.Wy = wy
    End Sub
    Public Sub Draw(ByVal g As Graphics)
        g.DrawRectangle(Pens.Red, Cx - Wx / 2, Cy - Wy / 2, Wx, Wy)
    End Sub
    ReadOnly Property Left
        Get
            Return Cx - Wx / 2
        End Get
    End Property
    Function Right() As Single
        Return Cx + Wx / 2
    End Function
    ReadOnly Property Bottom
        Get
            Return Cy + Wy / 2
        End Get
    End Property
    ReadOnly Property Top
        Get
            Return Cy - Wy / 2
        End Get
    End Property

End Class
